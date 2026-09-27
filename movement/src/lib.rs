pub mod domain;

use domain::master::{MasterTableBuilder, MasterTableError as DomainError};

uniffi::setup_scaffolding!();

#[derive(Debug, thiserror::Error, uniffi::Error)]
pub enum MasterError {
    #[error("Subject name cannot be empty")]
    MissingName,
}

impl From<DomainError> for MasterError {
    fn from(err: DomainError) -> Self {
        match err {
            DomainError::MissingName => MasterError::MissingName,
        }
    }
}

#[derive(uniffi::Record, Debug, Clone, PartialEq, Eq)]
pub struct MasterRecord {
    pub subject_name: String,
    pub subject_code: Option<String>,
    pub expected_classes: Option<u32>,
    pub frequency_per_week: Option<u32>,
}

#[uniffi::export]
pub fn build_master_record(
    subject_name: String,
    subject_code: Option<String>,
    expected_classes: Option<u32>,
    frequency_per_week: Option<u32>,
) -> Result<MasterRecord, MasterError> {
    let mut builder = MasterTableBuilder::new().with_name(subject_name);

    if let Some(code) = subject_code {
        builder = builder.with_code(code);
    }
    if let Some(classes) = expected_classes {
        builder = builder.with_classes(classes);
    }
    if let Some(freq) = frequency_per_week {
        builder = builder.with_freq(freq);
    }

    let record = builder.build().map_err(MasterError::from)?;

    Ok(MasterRecord {
        subject_name: record.subject_name,
        subject_code: record.subject_code,
        expected_classes: record.expected_classes,
        frequency_per_week: record.frequency_per_week,
    })
}
